------- Roles -------
INSERT INTO public.roles(active, created_at, deleted_at, updated_at, created_by, deleted_by, role_id, updated_by, role_description, role_name) VALUES (true, null, null, null, null, null, '5fa73c03-a638-49de-ac32-cade52eb71f1', null, 'Usuarios', 'ROLE_USER');
INSERT INTO public.roles(active, created_at, deleted_at, updated_at, created_by, deleted_by, role_id, updated_by, role_description, role_name) VALUES (true, null, null, null, null, null, 'be768fa6-b00f-4309-9b28-e6b1188506a7', null, 'Administrador', 'ROLE_ADMIN');
INSERT INTO public.roles(active, created_at, deleted_at, updated_at, created_by, deleted_by, role_id, updated_by, role_description, role_name) VALUES (true, null, null, null, null, null, '11df03c2-dec2-45e1-b48b-52321a5640e8', null, 'Refugio', 'ROLE_SHELTER');

------- Country -------
INSERT INTO public.countries(country_id, country_name) VALUES ('1', 'Argentina');
INSERT INTO public.countries(country_id, country_name) VALUES ('2', 'Bolivia');
INSERT INTO public.countries(country_id, country_name) VALUES ('3', 'Chile');
INSERT INTO public.countries(country_id, country_name) VALUES ('4', 'Perú');
INSERT INTO public.countries(country_id, country_name) VALUES ('5', 'República Dominicana');

------ Department ------
INSERT INTO public.departments(country_id, department_id, department_name) VALUES (1, 1, 'Provincia de Buenos Aires');
INSERT INTO public.departments(country_id, department_id, department_name) VALUES (2, 2, 'La Paz');
INSERT INTO public.departments(country_id, department_id, department_name) VALUES (3, 3, 'Santiago');
INSERT INTO public.departments(country_id, department_id, department_name) VALUES (4, 4, 'Lima');
INSERT INTO public.departments(country_id, department_id, department_name) VALUES (5, 5, 'Santiago de Chile');

----- City ------
INSERT INTO public.cities(city_id, department_id, city_name) VALUES (1, 1, 'Buenos Aires');
INSERT INTO public.cities(city_id, department_id, city_name) VALUES (2, 2, 'La Paz');
INSERT INTO public.cities(city_id, department_id, city_name) VALUES (3, 3, 'Santiago');
INSERT INTO public.cities(city_id, department_id, city_name) VALUES (4, 4, 'Lima Metropolitana');

----- District ----
INSERT INTO public.districts(city_id, district_id, district_name) VALUES (1, 1, 'La Plata');
INSERT INTO public.districts(city_id, district_id, district_name) VALUES (2, 2, 'San Antonio');
INSERT INTO public.districts(city_id, district_id, district_name) VALUES (4, 4, 'Cercado de Lima')




