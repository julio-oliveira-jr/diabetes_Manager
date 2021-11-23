<template>
  <q-page>
    <q-card>
      <div class="row">
      <div class="col-sm-12 col-md-3 q-pa-sm">
          <q-input v-model="glicemia.datGlicemia" filled type="date" hint="Data"/>
        </div>
        <div class="col-sm-12 col-md-3 q-pa-sm">
          <q-input v-model="glicemia.hrGlicemia" filled type="time" hint="Horário"/>
        </div>
        <div class="col-sm-12 col-md-6 q-pa-sm">
          <q-input outlined v-model="glicemia.vlrGlicemia" label="Valor" type="numeric"></q-input>
        </div>
      </div>
      <div class="row">
        <div class="col-sm-12 col-md-1 q-pa-sm">
          <q-btn rounded color="green" text-color="white" label="Salvar" @click="salvar"/>
        </div>
         <div class="col-sm-12 col-md-1 q-pa-sm">
          <q-btn  rounded color="white" text-color="black" label="Limpar" @click="limpar"/>
         </div>
      </div>
    </q-card>
  </q-page>
</template>

<script>

import axios from 'axios';


export default {
  name: 'Glicemia',
  components: {},
  data: function () {
    return {
      glicemia: {
        datGlicemia: null,
        hrGlicemia: null
      }
    }
  },
  methods: {
    salvar () {
      axios.post('http://localhost:8082/glicemia/', this.setObjeto())
        .then(resp => {
          alert("Registro incluído com sucesso.");
        })
        .catch(err => {
        })
    },
    setObjeto(){
      const glicemiaFormatada = {
        vlrGlicemia: this.glicemia.vlrGlicemia,
        datGlicemia: new Date(),
        datCadastro: new Date(),
        datAlteracao: new Date(),
        usuario: "Caju" //TODO - FAZER LOGIN USUÁRIO, AUTENTICAÇÃO, AUTORIZAÇÃO, ETC
      }

      return glicemiaFormatada
    },
    carregamentoInicial(){
    }
  },
  mounted() {
    this.carregamentoInicial()
  }
}
</script>
