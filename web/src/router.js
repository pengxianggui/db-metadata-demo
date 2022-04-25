import Vue from 'vue'
import Router from 'vue-router'
import {MetaLayout} from 'db-metadata'

Vue.use(Router)

const routes = [
    // 编程路由
    {
        path: "/",
        component: MetaLayout,
        redirect: '/dashboard',
        children: [
            {
                name: 'Route1-1',
                path: 'route1-1',
                component: () => import('@/views/Route1_1'),
                meta: {title: '路由1-1', order: 1},
                props: {oc: 'meta_dict'}
            },
            {
                name: 'Route1-2',
                path: 'route1-2',
                component: () => import('@/views/Route1_2'),
                meta: {title: '路由1-2', order: 0, disable: true}, // 对编程路由而言，disable是不生效的
                props: {oc: 'meta_dict'}
            },
        ]
    },
]

const router = new Router({
    routes: routes
})
export default router
