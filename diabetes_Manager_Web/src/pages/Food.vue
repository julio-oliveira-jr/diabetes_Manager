<template>
  <q-page>
    <q-card>
      <div class="row">
        <div class="col-sm-12 col-md-12 q-pa-sm">
          <q-input outlined v-model="food.description" type="text" label="Descrição completa" :error="!descriptionValidation" error-message="Descrição completa é obrigatória!" maxlength="50" autogrow="true"/>
        </div>
        <div class="col-sm-12 col-md-6 q-pa-sm">
          <q-input outlined v-model="food.summaryDescription" type="text" label="Descrição resumida" maxlength="25"/>
        </div>
        <div class="col-sm-12 col-md-3 q-pa-sm">
          <q-input outlined v-model="food.foodQty" label="Quantidade de alimento (g)" type="numeric" :error="!foodQtyValidation" error-message="Quantidade de alimento é obrigatória!" maxlength="4"></q-input>
        </div>
        <div class="col-sm-12 col-md-3 q-pa-sm">
          <q-input outlined v-model="food.carbohydrateGramQty" label="Quantidade de carboidrato (g)" type="numeric" :error="!carbohydrateQtyValidation" error-message="Quantidade de carboidrato é obrigatória!" maxlength="4"></q-input>
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
  name: 'FoodPage',
  components: {},
  data: function () {
    return {
      food: {},
      foodQtyValidation: true,
      carbohydrateQtyValidation: true,
      descriptionValidation: true
    }
  },
  methods: {
    save () {
      if(this.validate()){
        axios.post('http://localhost:8082/food/', this.setObject())
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
      this.foodQtyValidation = true
      this.carbohydrateQtyValidation = true
      this.descriptionValidation = true

      if(this.food.foodQty == null || this.food.foodQty == undefined ||  this.food.foodQty == ''){
        valid = false
        this.foodQtyValidation = false
      }

      if(this.food.carbohydrateQty == null || this.food.carbohydrateQty == undefined ||  this.food.carbohydrateQty == ''){
        valid = false
        this.carbohydrateQtyValidation = false
      }

      if(this.food.description == null || this.food.description == undefined ||  this.food.description == ''){
        valid = false
        this.descriptionValidation = false
      }

      return valid
    },
     //TODO - IMPLEMENTAR UMA FORMATAÇÃO DE DATA NO UTILS
    setObject(){
      const food = {
        description: this.insulinCalculation.description,
        summaryDescription: this.insulinCalculation.summaryDescription,
        carbohydrateQty: this.insulinCalculation.carbohydrateQty,
        foodQty: this.insulinCalculation.foodQty,
        carbohydrateGramQty: this.insulinCalculation.carbohydrateGramQty,
        // TODO - IMPLEMENTAR UM UNDEFINED TO NULL
        registerDate: this.food.registerDate == undefined ? null : this.food.registerDate,
        lastUpdateDate: this.food.lastUpdateDate == undefined ? null : this.food.lastUpdateDate,
        user: "Caju" //TODO - FAZER LOGIN USUÁRIO, AUTENTICAÇÃO, AUTORIZAÇÃO, ETC
      }

      return food
    },
    inicializationLoad(){
    }
  },
  mounted() {
    this.inicializationLoad()
  }
}
</script>
