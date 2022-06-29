<template>
  <q-page>
    <q-card>
      <div class="row">
        <q-select outlined v-model="insulinCalculationType" :options="insulinCalculationTypeArray" label="Tipo de cálculo de insulina">
          <template v-slot:after>
            <q-btn round dense flat icon="add" @click="showAddCard('insulinCalculationType')" />
          </template>
        </q-select>
      </div>
      <div class="row">
        <q-select outlined v-model="glucose" :options="glucoseArray" label="Glicemia">
          <template v-slot:after>
            <q-btn round dense flat icon="add" @click="showAddCard('bloodGlucose')" />
          </template>
        </q-select>
      </div>
      <div class="row">
        <div class="col">
          <q-select
            outlined 
            v-model="foodsIds"
            multiple
            use-input
            hide-selected
            fill-input
            input-debounce="0"
            :options="foodsArray"
            label="Alimentos"
            @filter="filterFn"
            hint="Digite no mínimo 2 caracteres!"
            style="width: 250px; padding-bottom: 32px"
          >
            <template v-slot:no-option>
              <q-item>
                <q-item-section class="text-grey">
                  Sem resultados!
                </q-item-section>
              </q-item>
            </template>
            <template v-slot:after>
              <q-btn round dense flat icon="add" @click="showAddCard('food')" />
            </template>
          </q-select>
        </div>
        <div class="col" v-for="foodId in foodsIds" :key="foodId">
          <q-input
            v-model.number="carbohydrateArray[foodId]"
            type="number"
            filled
            style="max-width: 200px"
          />
        </div>
      </div>
      <q-dialog v-model="enableAddCard" persistent>
        <q-card>
          <q-card-section class="row items-center">
            <div class="row" v-if="entityType === 'food'">
              <div class="col-sm-12 col-md-12 q-pa-sm">
                <q-input outlined v-model="food.description" type="text" label="Descrição completa" :error="!descriptionValidation" error-message="Descrição completa é obrigatória!" maxlength="50" autogrow="true"/>
              </div>
              <div class="col-sm-12 col-md-6 q-pa-sm">
                <q-input outlined v-model="food.summaryDescription" type="text" label="Descrição resumida" maxlength="25"/>
              </div>
              <div class="col-sm-12 col-md-3 q-pa-sm">
                <q-input outlined v-model="food.foodQty" label="Quantidade" type="numeric" :error="!foodQtyValidation" error-message="Quantidade de alimento é obrigatória!" maxlength="4"/>
              </div>
             <div class="col-sm-12 col-md-12 q-pa-sm">
                <q-select outlined v-model="food.measureUnity" :options="measureUnityArray" label="Unidade de medida" :error="!measureUnityValidation" error-message="Unidade de medida é obrigatória!">
                  <template v-slot:after>
                    <q-btn round dense flat icon="add" @click="showAddCard('measureUnity')" />
                  </template>
                </q-select>
              </div>
              <div class="col-sm-12 col-md-3 q-pa-sm">
                <q-input outlined v-model="food.carbohydrateQty" label="Quantidade de carboidratos" type="numeric" :error="!carbohydrateQtyValidation" error-message="Quantidade de carboidrato é obrigatória!" maxlength="4"/>
              </div>
            </div>
            <div class="row" v-if="entityType === 'bloodGlucose'">
              <div class="col-sm-12 col-md-3 q-pa-sm">
                <q-input outlined v-model="bloodGlucose.date" type="date" hint="Data" :error="!dataValidation" error-message="Data é obrigatória!"/>
              </div>
              <div class="col-sm-12 col-md-3 q-pa-sm">
                <q-input outlined v-model="bloodGlucose.hour" type="time" hint="Horário" :error="!hourValidation" error-message="Horário é obrigatório!"/>
              </div>
            </div>
            <div class="row" v-if="entityType === 'insulinCalculationType'">
              <div class="col-sm-12 col-md-12 q-pa-sm">
                <q-select outlined v-model="insulinCalculationType.calculationTypeInd" :options="arrayTipoCalculo" label="Tipo de cálculo" :error="!calculationTypeValidation" error-message="Tipo de cálculo é obrigatório!"/>
              </div>
              <div class="col-sm-12 col-md-6 q-pa-sm">
                <q-select outlined v-model="insulinCalculationType.timeTypeInd" :options="arrayTipoHorario" label="Tipo de horário" :error="!timeTypeValidation" error-message="Tipo de horário é obrigatório!"/>
              </div>
              <div class="col-sm-12 col-md-3 q-pa-sm">
                <q-input outlined v-model="insulinCalculationType.optimalGlucoseValue" label="Valor da glicemia ideal" type="numeric" :error="!optimalGlucoseValidation" error-message="Valor da glicemia ideal é obrigatório!" maxlength="4"/>
              </div>
              <div class="col-sm-12 col-md-3 q-pa-sm">
                <q-input outlined v-model="insulinCalculationType.variationSensorValue" label="Valor do sensor de variação" type="numeric" :error="!variationSensorValidation" error-message="Valor do sensor de variacao é obrigatório!" maxlength="4"/>
              </div>
            </div>
            <div class="row" v-if="entityType === 'measureUnity'">
              <div class="col-sm-12 col-md-3 q-pa-sm">
                <q-input outlined v-model="measureUnity.description" label="Descrição" type="text" :error="!descriptionValidation" error-message="Descrição é um campo obrigatório!" maxlength="50"/>
              </div>
              <div class="col-sm-12 col-md-3 q-pa-sm">
                <q-input outlined v-model="measureUnity.symbol" label="Simbologia" type="text" :error="!symbolValidation" error-message="Simbologia é um campo obrigatório!" maxlength="10"/>
              </div>
            </div>
          </q-card-section>

          <q-card-actions align="right">
            <q-btn flat label="Cancelar" color="red" v-close-popup @click="clean"/>
            <q-btn flat label="Confirmar" color="green" v-close-popup @click="save"/>
          </q-card-actions>
        </q-card>
      </q-dialog>
    </q-card>
  </q-page>
</template>

<script>

import axios from 'axios';
import { ref } from 'vue'

export default {
  name: 'InsulinCalculation',
  components: {},
  data: function () {
    return {
      enableAddCard: false,
      entityType: '',
      insulinCalculation: {
        alimentaryBolus: {},
        correctionBolus: {}
      },
      insulinCalculationType: {},
      glucose: {},
      food: {},
      measureUnity: {},
      foodsIds: [],
      loadedArrays: [],
      bloodGlucoseArray: [],
      insulinCalculationTypeArray: [],
      foodsArray: [],
      carbohydrateArray: [],
      measureUnityArray: []
    }
  },
  methods: {
    save () {
      if(this.validate()){
        axios.post(`http://localhost:8082/${this.entityType}/`, this.setObject())
          .then(resp => {
            alert("Registro incluído com sucesso.");
          })
          .catch(err => {
          })
      }
    },
    //TODO - IMPLEMENTAR UM VALIDAR NO UTILS
    validate() {
      var valid = true;

      return valid;
    },
     //TODO - IMPLEMENTAR UMA FORMATAÇÃO DE DATA NO UTILS
    setObject() {
      var object = {};

      if(this.entityType === 'insulinCalculation'){
        object = {
          // TODO - IMPLEMENTAR UM UNDEFINED TO NULL
          alimentaryBolus: this.insulinCalculation.alimentaryBolus,
          correctionBolus: this.insulinCalculation.correctionBolus
         
        }
      } else if(this.entityType === 'insulinCalculationType'){
        object = {
          // TODO - IMPLEMENTAR UM UNDEFINED TO NULL
          calculationTypeInd: this.insulinCalculationType.calculationTypeInd,
          timeTypeInd: this.insulinCalculationType.timeTypeInd,
          optimalGlucoseValue: this.insulinCalculationType.optimalGlucoseValue,
          variationSensorValue: this.insulinCalculation.variationSensorValue
        }
      } else if(this.entityType === 'food'){
        object = {
          // TODO - IMPLEMENTAR UM UNDEFINED TO NULL
          description: this.food.description,
          summaryDescription: this.food.summaryDescription,
          qtyPerPortion: this.food.qtyPerPortion,
          measureUnity: this.food.measureUnity,
          carbohydrateQty: this.food.carbohydrateQty
        }
      } else if(this.entityType === 'bloodGlucose'){
        object = {
          // TODO - IMPLEMENTAR UM UNDEFINED TO NULL
          date: this.bloodGlucose.date,
          hour: this.bloodGlucose.hour,
          value: this.bloodGlucose.value
        }
      } else if(this.entityType === 'measureUnity') {
        // TODO - IMPLEMENTAR UM UNDEFINED TO NULL
        object = {
          // TODO - IMPLEMENTAR UM UNDEFINED TO NULL
          description: this.measureUnity.description,
          symbol: this.measureUnity.symbol
        }
      }
      object = this.setDefaultAttributes(object);
      return object;
    },
    inicializationLoad() { 
      this.insulinCalculationTypeArray = this.getResource('insulinCalculationTypeArray');
      this.bloodGlucoseArray = this.getResource('glucose');
      // this.foodsArray = this.variableInicialization('foods');
    },
    getResource(resourceName, filter) { 
      if(filter == null) filter = '';
      axios.get(`http://localhost:8082/${resourceName}/search/${filter}`)
          .then(resp => {
            return resp[variable];
          })
          .catch(err => {
          })
    },
    showAddCard(entityType) {
      this.entityType = entityType;
      this.enableAddCard = true;
    },
    setup () {
      const model = ref(null);
      const options = ref(this.foodsArray);

      return {
        model,
        options,
        filterFn (val, update, abort) {
          update(() => {
            this.foodsArray = this.getVariables('foods', val);
          })
        },
        setModel (val) {
          model.value = val;
        }
      }
    },
    clean(){
      this.insulinCalculationType = {};
      this.food = {};
      this.bloodGlucose = {};
    },
    setDefaultAttributes(object) {
       object.registerDate = null;
       object.modifiedDate = null; 
       object.userId = 1; //TODO - FAZER LOGIN USUÁRIO, AUTENTICAÇÃO, AUTORIZAÇÃO, ETC

       return object;
    }
  },
  mounted() {
    this.inicializationLoad();
  }
}
</script>
