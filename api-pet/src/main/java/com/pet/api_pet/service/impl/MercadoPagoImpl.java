package com.pet.api_pet.service.impl;

import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.preference.*;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.preference.Preference;
import com.pet.api_pet.dto.CompraRealizadaDTO;
import com.pet.api_pet.model.CompraRealizada;
import com.pet.api_pet.repository.IGenericRepo;
import com.pet.api_pet.repository.IMercadoPagoRepo;
import com.pet.api_pet.service.IMercadoPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MercadoPagoImpl extends CRUDServiceImpl<CompraRealizada, UUID> implements IMercadoPagoService {

    @Autowired
    private IMercadoPagoRepo repo;

    @Value("${mercadopago.access_token}")
    private String mercadoPagoToken;

    @Override
    protected IGenericRepo<CompraRealizada, UUID> getRepo() {
        return repo;
    }

    @Override
    public String ProductoId(List<CompraRealizadaDTO> productos) {
        try {

            MercadoPagoConfig.setAccessToken(mercadoPagoToken);

            //CREACION DE PREFERENCIAS
            //Preferencia de Compra
            List<PreferenceItemRequest> items = productos.stream().map(producto ->
                    PreferenceItemRequest.builder()
                            .id(producto.getId().toString())
                            .title(producto.getTitle())
                            .description(producto.getDescription())
                            .pictureUrl(producto.getPictureUrl())
                            .categoryId(producto.getCategoryId())
                            .quantity(producto.getQuantity())
                            .currencyId(producto.getCurrencyId())
                            .unitPrice(producto.getUnitPrice())
                            .build()
            ).collect(Collectors.toList());

            //Control de Preferencias Exitosas
            PreferenceBackUrlsRequest backUrls = PreferenceBackUrlsRequest.builder()
                    .success("https://www.youtube.com/")
                    .pending("https://www.youtube.com/")
                    .failure("https://www.google.com.ar/")
                    .build();

            //Crea una Preferencia que contendrá todas las Preferencias creadas anteriormente
            PreferenceRequest preferenceRequest = PreferenceRequest.builder()
                    .items(items)
                    .backUrls(backUrls)
                    .autoReturn("approved")
                    .notificationUrl("https://www.your-site.com/ipn")
                    .statementDescriptor("Mi App")
                    .externalReference("Reference_1234")
                    .expires(true)
                    //.expirationDateFrom("2016-02-01T12:00:00.000-04:00")
                    //.expirationDateTo("2016-02-28T12:00:00.000-04:00")
                    .build();

            //Crear un objeto de tipo Cliente para comunicarnos con MP
            PreferenceClient client = new PreferenceClient();

            //Esto se encarga de crear la Preferencia Padre que contendra todas las demás preferencias creadas
            Preference preference = client.create(preferenceRequest);

            //Se retorna la Preferencia Padr e pero en solo el id en este caso
            return preference.getId();

        } catch (MPException | MPApiException error) {
            return error.toString();
        }
    }
}
