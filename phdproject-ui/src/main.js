import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import * as axios from 'axios'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import {
  BTable,
  BPagination,
  BFormCheckbox,
  BForm,
  BButton,
  BDropdown,
  BDropdownItem,
  BTableSimple,
  BThead, BTh, BTr, BTbody, BTd, BCard, BCardText, BImg, BNavbarBrand, BNavbar
} from 'bootstrap-vue'

Vue.component('b-button', BButton)
Vue.component('b-form', BForm)
Vue.component('b-checkbox', BFormCheckbox)
Vue.component('b-pagination', BPagination)
Vue.component('b-table', BTable)
Vue.component('b-dropdown', BDropdown)
Vue.component('b-dropdown-item', BDropdownItem)
Vue.component('b-table-simple', BTableSimple)
Vue.component('b-thead', BThead)
Vue.component('b-th', BTh)
Vue.component('b-tr', BTr)
Vue.component('b-tbody', BTbody)
Vue.component('b-td', BTd)
Vue.component('b-card', BCard)
Vue.component('b-card-text', BCardText)
Vue.component('b-img', BImg)
Vue.component('b-navbar-brand', BNavbarBrand)
Vue.component('b-navbar', BNavbar)
Vue.prototype.$axios = axios
Vue.config.productionTip = false

new Vue({
  router,
  store,
  axios,
  render: h => h(App)
}).$mount('#app')
