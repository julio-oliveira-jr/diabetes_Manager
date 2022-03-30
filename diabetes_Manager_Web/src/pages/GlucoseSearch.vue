<template>
  <div class="q-pa-md">
    <div class="row">
      <div class="col-sm-12 col-md-8">
        <q-date v-model="filtro" range/>
      </div>
    </div>
   <div class="q-pt-md">
    <q-card class>
      <q-table
        :data="data"
        :columns="columns"
        row-key="name">
        </q-table>
    </q-card>
    </div>
  </div>
</template>

<script>

import axios from 'axios';
import { ref } from 'vue';

export default {
  name: 'GlucoseSearch',
  components: {},
  data: function () {
    return {
      filter: '',
      datLimInf: null,
      datLimSup: null,
      columns: [
        { name: 'glucoseDate', align: 'left', label: 'Data', field: 'glucoseDate', sortable: true },
        { name: 'glucoseHour', align: 'left', label: 'Horário', field: 'glucoseHour', sortable: true },
        {
          name: 'glucoseValue',
          required: true,
          label: 'Valor da glicemia',
          align: 'left',
          field: 'glucoseValue',
          format: val => `${val}`,
          sortable: true,
          classes: 'bg-grey-2 ellipsis',
          style: 'max-width: 100px',
          headerClasses: 'bg-primary text-white'
        },
        { name: 'lastUpdateDate', align: 'left', label: 'Data de atualização', field: 'lastUpdateDate', sortable: true }
      ],
      data: []
    }
  },
  methods: {
    searchGlucoses(){
      console.log('buscando glicemias')
      this.from = this.filter.from == undefined ? null : this.filter.from
      this.to = this.filter.to == undefined ? null : this.filter.to

      var url = `http://localhost:8082/glucose/search`
      
      if(this.from != null){
        url += `?from=${this.from}`
      }

      if(this.to != null && this.to != null){
        url += `&to=${this.to}`
      }

      axios.get(url)
          .then(resp => {
            this.data = resp.data
          })
          .catch(err => {
          })
    },
    carregamentoInicial(){
      this.searchGlucoses()
    }
  },
  mounted() {
    this.searchGlucoses()
  },
  watch: {
    filter: function () {
      this.searchGlucoses()
    }
  }
}
</script>