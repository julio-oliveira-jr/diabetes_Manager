<template>
  <q-page>
    <q-card>
      <div class="row">
      <div class="col-sm-12 col-md-3 q-pa-sm">
          <q-input outlined v-model="glicemia.datGlicemia" type="date" hint="Data" :error="!validaData" error-message="Data é obrigatória!"/>
        </div>
        <div class="col-sm-12 col-md-3 q-pa-sm">
          <q-input outlined v-model="glicemia.hrGlicemia" type="time" hint="Horário" :error="!validaHorario" error-message="Horário é obrigatório!"/>
        </div>
        <div class="col-sm-12 col-md-6 q-pa-sm">
          <q-input outlined v-model="glicemia.vlrGlicemia" label="Valor" type="numeric" :error="!validaValor" error-message="Valor é obrigatório!" maxlength="3"></q-input>
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
      },
      validaData: true,
      validaHorario: true,
      validaValor: true
    }
  },
  methods: {
    salvar () {
      if(this.validar()){
        axios.post('http://localhost:8082/glicemia/', this.setObjeto())
          .then(resp => {
            alert("Registro incluído com sucesso.");
          })
          .catch(err => {
          })
      }
    },
    //TODO - IMPLEMENTAR UM VALIDAR NO UTILS
    validar(){
      var valida = true
      this.validaValor = true
      this.validaHorario = true
      this.validaData = true

      if(this.glicemia.vlrGlicemia == null || this.glicemia.vlrGlicemia == undefined ||  this.glicemia.vlrGlicemia == ''){
        valida = false
        this.validaValor = false
      }

      if(this.glicemia.datGlicemia == null || this.glicemia.datGlicemia == undefined ||  this.glicemia.datGlicemia == ''){
        valida = false
        this.validaData = false
      }

      if(this.glicemia.hrGlicemia == null || this.glicemia.hrGlicemia == undefined ||  this.glicemia.hrGlicemia == ''){
        valida = false
        this.validaHorario = false
      }

      return valida
    },
     //TODO - IMPLEMENTAR UMA FORMATAÇÃO DE DATA NO UTILS
    setObjeto(){
      var datGlicemia = this.glicemia.datGlicemia

      datGlicemia = datGlicemia.replace(/\.|\-/g, '/');

      var aux = datGlicemia.split("/")

      datGlicemia = new Date(aux[0], aux[1], aux[2])

      const glicemia = {
        vlrGlicemia: this.glicemia.vlrGlicemia,
        datGlicemia: datGlicemia,
        datCadastro: new Date(),
        hrGlicemia: this.glicemia.hrGlicemia,
        datAlteracao: null,
        usuario: "Caju" //TODO - FAZER LOGIN USUÁRIO, AUTENTICAÇÃO, AUTORIZAÇÃO, ETC
      }

      return glicemia
    },
    carregamentoInicial(){
    }
  },
  mounted() {
    this.carregamentoInicial()
  }
}
</script>
