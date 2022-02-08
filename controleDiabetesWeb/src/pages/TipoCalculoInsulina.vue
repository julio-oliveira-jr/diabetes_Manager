<template>
  <q-page>
    <q-card>
      <div class="row">
        <div class="col-sm-12 col-md-12 q-pa-sm">
          <q-select outlined v-model="tipoCalculoInsulina.indTipoCalculo" :options="arrayTipoCalculo" label="Tipo de cálculo" :error="!validaTipoCalculo" error-message="Tipo de cálculo é obrigatório!"/>
        </div>
        <div class="col-sm-12 col-md-6 q-pa-sm">
          <q-select outlined v-model="tipoCalculoInsulina.indTipoHorario" :options="arrayTipoHorario" label="Tipo de horário" :error="!validaTipoHorario" error-message="Tipo de horário é obrigatório!"/>
        </div>
        <div class="col-sm-12 col-md-3 q-pa-sm">
          <q-input outlined v-model="tipoCalculoInsulina.vlrGlicemiaIdeal" label="Valor da glicemia ideal" type="numeric" :error="!validaVlrGlicemiaIdeal" error-message="Valor da glicemia ideal é obrigatório!" maxlength="4"></q-input>
        </div>
        <div class="col-sm-12 col-md-3 q-pa-sm">
          <q-input outlined v-model="tipoCalculoInsulina.vlrSensorVariacao" label="Valor do sensor de variação" type="numeric" :error="!validaVlrSensorVariacao" error-message="Valor do sensor de variacao é obrigatório!" maxlength="4"></q-input>
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
  name: 'TipoCalculoInsulina',
  components: {},
  data: function () {
    return {
      tipoCalculoInsulina: {},
      arrayTipoCalculo: [],
      arrayTipoHorario: [],
      validaVlrGlicemiaIdeal: true,
      validaVlrSensorVariacao: true,
      validaTipoCalculo: true,
      validaTipoHorario: true
    }
  },
  methods: {
    salvar () {
      if(this.validar()){
        axios.post('http://localhost:8082/tipoCalculoInsulina/', this.setObjeto())
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
      this.validaVlrGlicemiaIdeal = true
      this.validaVlrSensorVariacao = true
      this.validaTipoCalculo = true
      this.validaTipoHorario = true

      if(this.tipoCalculoInsulina.vlrGlicemiaIdeal == null || this.tipoCalculoInsulina.vlrGlicemiaIdeal == undefined ||  this.tipoCalculoInsulina.vlrGlicemiaIdeal == ''){
        valida = false
        this.validaVlrGlicemiaIdeal = false
      }

      if(this.tipoCalculoInsulina.vlrSensorVariacao == null || this.tipoCalculoInsulina.vlrSensorVariacao == undefined ||  this.tipoCalculoInsulina.vlrSensorVariacao == ''){
        valida = false
        this.validaVlrSensorVariacao = false
      }

      if(this.tipoCalculoInsulina.indTipoCalculo == null || this.tipoCalculoInsulina.indTipoCalculo == undefined ||  this.tipoCalculoInsulina.indTipoCalculo == ''){
        valida = false
        this.validaTipoCalculo = false
      }

      if(this.tipoCalculoInsulina.indTipoHorario == null || this.tipoCalculoInsulina.indTipoHorario == undefined ||  this.tipoCalculoInsulina.indTipoHorario == ''){
        valida = false
        this.validaTipoHorario = false
      }

      return valida
    },
     //TODO - IMPLEMENTAR UMA FORMATAÇÃO DE DATA NO UTILS
    setObjeto(){
      const tipoCalculoInsulina = {
        vlrGlicemiaIdeal: this.tipoCalculoInsulina.vlrGlicemiaIdeal,
        vlrSensorVariacao: this.tipoCalculoInsulina.vlrSensorVariacao,
        indTipoCalculo: this.tipoCalculoInsulina.indTipoCalculo,
        indTipoHorario: this.tipoCalculoInsulina.indTipoHorario,
         // TODO - IMPLEMENTAR UM UNDEFINED TO NULL
        datCadastro: this.tipoCalculoInsulina.datCadastro == undefined ? null : this.tipoCalculoInsulina.datCadastro,
        datAlteracao: this.tipoCalculoInsulina.datAlteracao == undefined ? null : this.tipoCalculoInsulina.datAlteracao,
        usuario: "Caju" //TODO - FAZER LOGIN USUÁRIO, AUTENTICAÇÃO, AUTORIZAÇÃO, ETC
      }

      return tipoCalculoInsulina
    },
    carregamentoInicial(){
      axios.get('http://localhost:8082/tipoCalculoInsulina/buscarTipoCalculoEnum/').then(resp => {
          this.arrayTipoCalculo = resp.tipoCalculoEnum 
        })
       
      axios.get('http://localhost:8082/tipoCalculoInsulina/buscarTipoHorarioEnum/').then(resp => {
          this.arrayTipoHorario = resp.tipoHorarioEnum
        })
    }
  },
  mounted() {
    this.carregamentoInicial()
  }
}
</script>
