import router from './router'
import menus from "./menu"

export default {
    axios: {
        baseURL: '/api'
    }, // axios实例(必须)
    router: router,
    menus: menus
}
