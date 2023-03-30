<template>
  <div style="background-image: url('https://i.pinimg.com/originals/16/84/50/168450927d230b5bbf9466ec704d393e.gif');
  background-size: cover; height:930px; padding-top:80px;">
    <h3>{{message}}</h3>
    <b-table
      stacked
      striped
      hover
      :fields="fields"
      :items="clients"
    >
      <template v-slot:cell(city)="data">
        <div v-if="data.item.city">
          {{ data.item.city.name }}
        </div>
        <div v-else>
          Няма град
        </div>
      </template>
      <template v-slot:cell(sex)="data">
        <div v-if="data.item.sex">
          {{ data.item.sex.type }}
        </div>
        <div v-else>
          Няма пари
        </div>
      </template>
      <template v-slot:cell(actions)="row">
        <router-link :to="{ name: 'ClientsTab', params: { id:row.item.id } }">Редактирай</router-link> |
        <b-button variant="danger" v-on:click="deleteClients(row.item.id)">Изтрий</b-button>
        <router-link :to="{ name: 'Clients' }"><h5>Връщане в главното меню</h5></router-link>
      </template>
    </b-table>
  </div>
</template>

<script>
import ClientService from '../services/clients-service'
export default {
  name: 'ClientsInfo',
  data () {
    return {
      message: '',
      row: '',
      clients: [{
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
      }],
      fields: [
        { key: 'firstName', label: 'Име' },
        { key: 'secondName', label: 'Презиме' },
        { key: 'lastName', label: 'Фамилия' },
        { key: 'nickName', label: 'Никнейм' },
        { key: 'sex', label: 'Пол' },
        { key: 'egn', label: 'ЕГН' },
        { key: 'city', label: 'Град' },
        { key: 'current', label: 'Разплащателна сметка' },
        { key: 'saving', label: 'Спестовна сметка' },
        { key: 'credit', label: 'Кредитна сметка' },
        { key: 'actions', label: 'Действия' }
      ],
      filters: {
        firstName: '',
        secondName: '',
        lastName: '',
        nickName: '',
        sex: '',
        egn: '',
        city: '',
        current: '',
        saving: '',
        credit: ''
      }
    }
  },
  beforeRouteEnter (to, from, next) {
    if (to.params.pass !== '0000') {
      next()
    }
    if (to.params.id) {
      ClientService.getClientsId(to.params.id).then(
        response =>
          next(vm =>
            vm.setData(response)
          )
      )
    } else next()
  },
  methods: {
    setData (response) {
      console.log(response)
      this.clients = response.data
    },
    deleteClients (id) {
      ClientService.deleteClientsId(id).then(
        response => {
          console.log(response)
          this.message = response.data
          this.searchClients()
        },
        error => {
          this.content =
            (error.response && error.response.data) ||
            error.message ||
            error.toString()
        }
      )
    }
  }
}
</script>

<style scoped>
</style>
