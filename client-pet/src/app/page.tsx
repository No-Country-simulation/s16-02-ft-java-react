import { Navbar, Footer } from "@components";

export default function Home() {
  return (
    <>
      <Navbar />
      <main id="main-content">
        <section className="main-content__hero">Hero Section</section>
        <section className="main-content__features">Features Section</section>
        <section className="main-content__services">Services Section</section>
        <section className="main-content__info">Info Section</section>
        <section className="main-content__reviews">Reviews Section</section>
        <section className="main-content__faq">FAQs Section</section>
      </main>
      <Footer />
    </>
  );
}
