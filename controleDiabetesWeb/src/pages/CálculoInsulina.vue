<template>
  <q-page>
    <q-card>
      <div class="row">
      </div>
    </q-card>
  </q-page>
</template>

<script>

import axios from 'axios';


export default {
  name: 'CalculoInsulina',
  components: {},
  data: function () {
    return {
      calculoInsulina: {}
    }
  },
  methods: {
    salvar () {
      if(this.validar()){
        axios.post('http://localhost:8082/calculoInsulina/', this.setObjeto())
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

      if(this.calculoInsulina.vlrGlicemiaIdeal == null || this.calculoInsulina.vlrGlicemiaIdeal == undefined ||  this.calculoInsulina.vlrGlicemiaIdeal == ''){
        valida = false
        this.validaVlrGlicemiaIdeal = false
      }

      if(this.calculoInsulina.vlrSensorVariacao == null || this.calculoInsulina.vlrSensorVariacao == undefined ||  this.calculoInsulina.vlrSensorVariacao == ''){
        valida = false
        this.validaVlrSensorVariacao = false
      }

      if(this.calculoInsulina.indTipoCalculo == null || this.calculoInsulina.indTipoCalculo == undefined ||  this.calculoInsulina.indTipoCalculo == ''){
        valida = false
        this.validaTipoCalculo = false
      }

      if(this.calculoInsulina.indTipoHorario == null || this.calculoInsulina.indTipoHorario == undefined ||  this.calculoInsulina.indTipoHorario == ''){
        valida = false
        this.validaTipoHorario = false
      }

      return valida
    },
     //TODO - IMPLEMENTAR UMA FORMATAÇÃO DE DATA NO UTILS
    setObjeto(){
      const calculoInsulina = {
        desCompleta: this.calculoInsulina.desCompleta,
        desResumida: this.calculoInsulina.desResumida,
        qtdCarboidrato: this.calculoInsulina.qtdCarboidrato,
        qtdAlimento: this.calculoInsulina.qtdAlimento,
        qtdCarboidratoGrama: this.calculoInsulina.qtdCarboidratoGrama,
         // TODO - IMPLEMENTAR UM UNDEFINED TO NULL
        datCadastro: this.calculoInsulina.datCadastro == undefined ? null : this.calculoInsulina.datCadastro,
        datAlteracao: this.calculoInsulina.datAlteracao == undefined ? null : this.calculoInsulina.datAlteracao,
        usuario: "Caju" //TODO - FAZER LOGIN USUÁRIO, AUTENTICAÇÃO, AUTORIZAÇÃO, ETC
      }

      return calculoInsulina
    },
    carregamentoInicial(){
    }
  },
  mounted() {
    this.carregamentoInicial()
  }
}
</script>
