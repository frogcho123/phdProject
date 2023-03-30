<template>
  <div style="background-image: url('https://blog.commlabindia.com/wp-content/uploads/2019/07/animated-gifs-corporate-training.gif');
  background-size: cover; height:930px; padding-top:80px;">
    <h3>{{message}}</h3>
    <button v-on:click="searchClients"><h3>Търси</h3></button>
    <b-table
      sort-by="id"
      id="clientTable"
      striped
      hover
      :fields="fields"
      :items="clients"
      :current-page:="currentPage"
      :per-page="0"
    >
      <template slot="top-row" slot-scope="{ fields }">
        <td v-for="(field, index) in fields" :key="field.id">
          <div v-if="index === fields.length - 1">
          </div>
          <div v-else>
            <input v-model="filters[field.key]">
          </div>
        </td>
      </template>
      <template v-slot:cell(city)="data">
        <div v-if="data.item.city">
          {{ data.item.city.name }}
        </div>
        <div v-else>
          Няма град
        </div>
      </template>

      <template v-slot:cell(sex)="data2">
        <div v-if="data2.item.sex">
          {{ data2.item.sex.type }}
        </div>
        <div v-else>
          Няма пари
        </div>
      </template>

      <template v-slot:cell(actions)="row">
        <router-link :to="{ name: 'Password', params: { id:row.item.id } }"><h5>Отвори</h5></router-link>
      </template>
    </b-table>
    <b-pagination
      @input="searchClients"
      v-model="currentPage"
      :total-rows="rows"
      :per-page="perPage"
      aria-controls="clientTable"
    ></b-pagination>
  </div>
</template>

<script>
import ClientService from '../services/clients-service'
export default {
  name: 'Clients',
  data () {
    return {
      message: '',
      currentPage: 1,
      rows: '',
      perPage: 3,
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
        { key: 'firstName', sortable: true, label: 'Име' },
        { key: 'secondName', sortable: true, label: 'Презиме' },
        { key: 'lastName', sortable: true, label: 'Фамилия' },
        { key: 'nickName', sortable: true, label: 'Никнейм' },
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
  mounted () {
    this.searchClients()
  },
  methods: {
    searchClients () {
      ClientService.getClientsPage(this.filters, this.currentPage, this.perPage).then(
        response => {
          // console.log(response)
          this.clients = response.data.clients
          this.rows = response.data.totalItems
        },
        error => {
          this.content =
            (error.response && error.response.data) ||
            error.message ||
            error.toString()
        }
      )
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
