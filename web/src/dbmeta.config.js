import router from './router'
import menus from "./menu"
import Route1_1 from "@/views/Route1_1";
import Route1_2 from "@/views/Route1_2";

export default {
    axios: {
        baseURL: '/api'
    }, // axios实例(必须)
    router: router,
    menus: menus,
    components: [Route1_1, Route1_2]
}
