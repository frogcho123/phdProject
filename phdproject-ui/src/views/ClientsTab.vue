<template>
  <div style="background-image: url('https://learn.g2.com/hs-fs/hubfs/plan%20gif%20marketing%20strategy.gif?width=500&name=plan%20gif%20marketing%20strategy.gif');
  background-size: cover; height:930px; padding-top:80px;">
    <h3>{{message}}</h3>
    <input type="text" v-model="clients.firstName" >
    <input type="text" v-model="clients.secondName" >
    <input type="text" v-model="clients.lastName" >
    <input type="text" v-model="clients.nickName" >
    <input type="number" v-model="clients.sex.id" >
    <br>
    <input type="number" v-model="clients.egn" >
    <input type="number" v-model="clients.city.id" >
    <input type="number" v-model="clients.current" >
    <input type="number" v-model="clients.saving" >
    <input type="number" v-model="clients.credit" >
    <br>
    <button v-on:click="saveClients"><h3>Редактирай</h3></button>
    <router-link :to="{ name: 'Clients' }"><h5>Връщане в главното меню</h5></router-link>
  </div>
</template>

<script>
import ClientService from '../services/clients-service'
export default {
  name: 'ClientsTab',
  data () {
    return {
      message: '',
      clients: {
        id: '',
        firstName: '',
        secondName: '',
        lastName: '',
        nickName: '',
        sex:
          {
            id: '',
            type: ''
          },
        egn: '',
        city:
          {
            id: '',
            name: ''
          },
        current: '',
        saving: '',
        credit: ''
      }
    }
  },
  beforeRouteEnter (to, from, next) {
    console.log(to)
    if (to.params.id) {
      ClientService.getClientsById(to.params.id).then(
        response =>
          next(vm =>
            vm.setData(response)
          )
      )
    } else {
      next()
    }
  },
  methods: {
    setData (response) {
      this.clients = response.data
    },
    saveClients () {
      ClientService.saveClients(this.clients).then(
        response => {
          console.log(response)
          this.clients = response.data.clients
          this.message = response.data.message
        },
        error => {
          this.message =
            (error.data.message.toString()) ||
            error.message ||
            (error.response && error.response.data)
        }
      )
    }
  }
}
</script>

<style scoped>
</style>
