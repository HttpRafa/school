use yew::prelude::*;

use crate::components::footer::Footer;
use crate::components::header::Header;
use crate::components::overview::Overview;

#[function_component(App)]
pub fn app() -> Html {
    html! {
        <div>
            <Header/>
            <Overview/>
            <Footer/>
        </div>
    }
}