<template>
  <q-page>
    <q-card>
      <div class="row">
      <div class="col-sm-12 col-md-3 q-pa-sm">
          <q-input outlined v-model="glucose.glucoseDate" type="date" hint="Data" :error="!dataValidation" error-message="Data é obrigatória!"/>
        </div>
        <div class="col-sm-12 col-md-3 q-pa-sm">
          <q-input outlined v-model="glucose.glucoseHour" type="time" hint="Horário" :error="!hourValidation" error-message="Horário é obrigatório!"/>
        </div>
        <div class="col-sm-12 col-md-6 q-pa-sm">
          <q-input outlined v-model="glucose.glucoseValue" label="Valor" type="numeric" :error="!valueValidation" error-message="Valor é obrigatório!" maxlength="3"></q-input>
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
  name: 'Glucose',
  components: {},
  data: function () {
    return {
      glucose: {
        glucoseDate: null,
        glucoseHour: null
      },
      valueValidation: true,
      hourValidation: true,
      dataValidation: true
    }
  },
  methods: {
    save () {
      if(this.validate()){
        axios.post('http://localhost:8082/glucose/', this.setObject())
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
      this.valueValidation = true
      this.hourValidation = true
      this.dataValidation = true

      if(this.glucose.glucoseValue == null || this.glucose.glucoseValue == undefined ||  this.glucose.glucoseValue == ''){
        valid = false
        this.valueValidation = false
      }

      if(this.glucose.glucoseHour == null || this.glucose.glucoseHour == undefined ||  this.glucose.glucoseHour == ''){
        valid = false
        this.hourValidation = false
      }

      if(this.glucose.glucoseData == null || this.glucose.glucoseData == undefined ||  this.glucose.glucoseData == ''){
        valid = false
        this.dataValidation = false
      }

      return valid
    },
     //TODO - IMPLEMENTAR UMA FORMATAÇÃO DE DATA NO UTILS
    setObject(){
      var glucoseDate = this.glucose.glucoseDate

      glucoseDate = glucoseDate.replace(/\.|\-/g, '/');

      var aux = glucoseDate.split("/")

      glucoseDate = new Date(aux[0], aux[1]-1, aux[2])

      const glucose = {
        glucoseValue: this.glucose.glucoseValue,
        glucoseDate: glucoseDate,
        glucoseHour: this.glucose.glucoseHour,
         // TODO - IMPLEMENTAR UM UNDEFINED TO NULL
        registerDate: this.glucose.registerDate == undefined ? null : this.glucose.registerDate,
        lastUpdateDate: this.glucose.lastUpdateDate == undefined ? null : this.glucose.lastUpdateDate,
        user: "Caju" //TODO - FAZER LOGIN USUÁRIO, AUTENTICAÇÃO, AUTORIZAÇÃO, ETC
      }

      return glucose
    },
    inicializationLoad(){
    }
  },
  mounted() {
    this.inicializationLoad()
  }
}
</script>
