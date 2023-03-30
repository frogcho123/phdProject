import axios from 'axios'

const API_URL = 'http://localhost:8080/clients'

class ClientService {
  getClients () {
    return axios.get(API_URL + '/all')
  }

  getClientsPage (filters, currentPage, perPage) {
    return axios.get(API_URL + '/search/page',
      {
        params:
          {
            firstName: filters.firstName,
            secondName: filters.secondName,
            lastName: filters.lastName,
            nickName: filters.nickName,
            sex: filters.sex,
            egn: filters.egn,
            city: filters.city,
            current: filters.current,
            saving: filters.saving,
            credit: filters.credit,
            currentPage: currentPage,
            perPage: perPage
          }
      })
  }

  saveClients (form) {
    return axios.post(API_URL + '/save', {
      id: form.id,
      firstName: form.firstName,
      secondName: form.secondName,
      lastName: form.lastName,
      nickName: form.nickName,
      sex: form.sex.id,
      egn: form.egn,
      city: form.city.id,
      current: form.current,
      saving: form.saving,
      credit: form.credit
    })
  }

  getClientsId (id) {
    return axios.get(API_URL + '/search/id',
      {
        params:
          {
            id: id
          }
      })
  }

  getClientsById (id) {
    return axios.get(API_URL + '/search/byId',
      {
        params:
          {
            id: id
          }
      })
  }

  deleteClientsId (id) {
    return axios.delete(API_URL + '/delete',
      {
        params:
          {
            id: id
          }
      })
  }

  accessClients (id) {
    return axios.get(API_URL + '/access',
      {
        params:
          {
            id: id
          }
      })
  }
}

export default new ClientService()
