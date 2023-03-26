use yew::prelude::*;
use crate::components::overview::Overview;
use crate::components::header::Header;
use crate::components::footer::Footer;

#[function_component(App)]
pub fn app() -> Html {
    html! {
        <main>
            <Header/>
            <Overview/>
            <Footer/>
        </main>
    }
}