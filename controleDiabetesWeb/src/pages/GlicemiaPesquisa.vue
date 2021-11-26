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
        :data="conteudo"
        :columns="colunas"
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
  name: 'GlicemiaPesquisa',
  components: {},
  data: function () {
    return {
      filtro: '',
      datLimInf: null,
      datLimSup: null,
      colunas: [
        { name: 'datGlicemia', align: 'left', label: 'Data', field: 'datGlicemia', sortable: true },
        { name: 'hrGlicemia', align: 'left', label: 'Horário', field: 'hrGlicemia', sortable: true },
        {
          name: 'vlrGlicemia',
          required: true,
          label: 'Valor da glicemia',
          align: 'left',
          field: 'vlrGlicemia',
          format: val => `${val}`,
          sortable: true,
          classes: 'bg-grey-2 ellipsis',
          style: 'max-width: 100px',
          headerClasses: 'bg-primary text-white'
        },
        { name: 'datAtualizacao', align: 'left', label: 'Data de atualização', field: 'datAtualizacao', sortable: true }
      ],
      conteudo: []
    }
  },
  methods: {
    buscarGlicemias(){
      console.log('buscando glicemias')
      this.datLimInf = this.filtro.from == undefined ? null : this.filtro.from
      this.datLimSup = this.filtro.to == undefined ? null : this.filtro.to

      var url = `http://localhost:8082/glicemia/buscarGlicemias`
      
      if(this.datLimInf != null){
        url += `?datLimInf=${this.datLimInf}`
      }

      if(this.datLimInf != null && this.datLimSup != null){
        url += `&datLimSup=${this.datLimSup}`
      }

      axios.get(url)
          .then(resp => {
            this.conteudo = resp.data
          })
          .catch(err => {
          })
    },
    carregamentoInicial(){
      this.buscarGlicemias()
    }
  },
  mounted() {
    this.buscarGlicemias()
  },
  watch: {
    filtro: function () {
      this.buscarGlicemias()
    }
  }
}
</script>