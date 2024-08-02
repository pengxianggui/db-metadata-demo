import router from './router'
import menus from "./menu"
import Route1_1 from "@/views/Route1_1";
import Route1_2 from "@/views/Route1_2";
import FinanceLog from "@/views/finance/finance-log.vue";
import Stock from "@/views/inventory/stock.vue";
import StockLog from "@/views/inventory/stock-log.vue";
import Product from "@/views/product/product.vue";
import Warehouse from "@/views/warehouse/warehouse.vue";

export default {
    axios: {
        baseURL: process.env.VUE_APP_BASE_API
    }, // axios实例(必须)
    router: router,
    menus: menus,
    components: [Route1_1, Route1_2, FinanceLog, Stock, StockLog, Product, Warehouse]
}
