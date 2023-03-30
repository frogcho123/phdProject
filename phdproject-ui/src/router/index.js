import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Clients from '../views/Clients.vue'
import ClientsTab from '../views/ClientsTab.vue'
import Password from '../views/Password.vue'
import ClientsInfo from '../views/ClientsInfo.vue'
Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/clients',
    name: 'Clients',
    component: Clients
  },
  {
    path: '/clientsInfo',
    name: 'ClientsInfo',
    component: ClientsInfo
  },
  {
    path: '/clientsTab',
    name: 'ClientsTab',
    component: ClientsTab
  },
  {
    path: '/password',
    name: 'Password',
    component: Password
  },

  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  }
]

const router = new VueRouter({
  routes
})

export default router
