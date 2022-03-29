<template>
  <q-page>
    <q-card>
      <div class="row">
        <div class="col-sm-12 col-md-12 q-pa-sm">
          <q-select outlined v-model="insulinCalculationType.calculationTypeInd" :options="arrayTipoCalculo" label="Tipo de cálculo" :error="!calculationTypeValidation" error-message="Tipo de cálculo é obrigatório!"/>
        </div>
        <div class="col-sm-12 col-md-6 q-pa-sm">
          <q-select outlined v-model="insulinCalculationType.timeTypeInd" :options="arrayTipoHorario" label="Tipo de horário" :error="!timeTypeValidation" error-message="Tipo de horário é obrigatório!"/>
        </div>
        <div class="col-sm-12 col-md-3 q-pa-sm">
          <q-input outlined v-model="insulinCalculationType.optimalGlucoseValue" label="Valor da glicemia ideal" type="numeric" :error="!optimalGlucoseValidation" error-message="Valor da glicemia ideal é obrigatório!" maxlength="4"></q-input>
        </div>
        <div class="col-sm-12 col-md-3 q-pa-sm">
          <q-input outlined v-model="insulinCalculationType.variationSensorValue" label="Valor do sensor de variação" type="numeric" :error="!variationSensorValidation" error-message="Valor do sensor de variacao é obrigatório!" maxlength="4"></q-input>
        </div>
      </div>
      <div class="row">
        <div class="col-sm-12 col-md-1 q-pa-sm">
          <q-btn rounded color="green" text-color="white" label="Salvar" @click="save"/>
        </div>
         <div class="col-sm-12 col-md-1 q-pa-sm">
          <q-btn  rounded color="white" text-color="black" label="Limpar" @click="clear"/>
         </div>
      </div>
    </q-card>
  </q-page>
</template>

<script>

import axios from 'axios';


export default {
  name: 'InsulinCalculationType',
  components: {},
  data: function () {
    return {
      insulinCalculationType: {},
      calculationTypeArray: [],
      timeTypeArray: [],
      optimalGlucoseValidation: true,
      variationSensorValidation: true,
      calculationTypeValidation: true,
      timeTypeValidation: true
    }
  },
  methods: {
    save () {
      if(this.validate()){
        axios.post('http://localhost:8082/insulinCalculationType/', this.setObject())
          .then(resp => {
            alert("Registro incluído com sucesso.");
          })
          .catch(err => {
          })
      }
    },
    //TODO - IMPLEMENTAR UM VALIDAR NO UTILS
    validate(){
      var valid = true
      this.optimalGlucoseValidation = true
      this.variationSensorValidation = true
      this.calculationTypeValidation = true
      this.timeTypeValidation = true

      if(this.insulinCalculationType.optimalGlucoseValue == null || this.insulinCalculationType.optimalGlucoseValue == undefined ||  this.insulinCalculationType.optimalGlucoseValue == ''){
        valid = false
        this.optimalGlucoseValidation = false
      }

      if(this.insulinCalculationType.variationSensorValue == null || this.insulinCalculationType.variationSensorValue == undefined ||  this.insulinCalculationType.variationSensorValue == ''){
        valid = false
        this.variationSensorValidation = false
      }

      if(this.insulinCalculationType.calculationTypeInd == null || this.insulinCalculationType.calculationTypeInd == undefined ||  this.insulinCalculationType.calculationTypeInd == ''){
        valid = false
        this.calculationTypeValidation = false
      }

      if(this.insulinCalculationType.timeTypeInd == null || this.insulinCalculationType.timeTypeInd == undefined ||  this.insulinCalculationType.timeTypeInd == ''){
        valid = false
        this.timeTypeValidation = false
      }

      return valid
    },
     //TODO - IMPLEMENTAR UMA FORMATAÇÃO DE DATA NO UTILS
    setObject(){
      const insulinCalculationType = {
        optimalGlucoseValue: this.insulinCalculationType.optimalGlucoseValue,
        variationSensorValue: this.insulinCalculationType.variationSensorValue,
        calculationTypeInd: this.insulinCalculationType.calculationTypeInd,
        timeTypeInd: this.insulinCalculationType.timeTypeInd,
         // TODO - IMPLEMENTAR UM UNDEFINED TO NULL
        registerDate: this.insulinCalculationType.datCadastro == undefined ? null : this.insulinCalculationType.datCadastro,
        lastUpdateDate: this.insulinCalculationType.datAlteracao == undefined ? null : this.insulinCalculationType.datAlteracao,
        user: "Caju" //TODO - FAZER LOGIN USUÁRIO, AUTENTICAÇÃO, AUTORIZAÇÃO, ETC
      }

      return insulinCalculationType
    },
    inicializationLoad(){
      axios.get('http://localhost:8082/insulinCalculationType/searchCalculationType/').then(resp => {
          this.calculationTypeArray = resp.calculationTypeEnum 
        })
       
      axios.get('http://localhost:8082/insulinCalculationType/searchTimeType/').then(resp => {
          this.timeTypeEnum = resp.timeTypeEnum
        })
    }
  },
  mounted() {
    this.inicializationLoad()
  }
}
</script>
