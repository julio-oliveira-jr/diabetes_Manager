<template>
  <q-page>
    <q-card>
      <div class="row">
      <div class="col-sm-12 col-md-12 q-pa-sm">
          <q-input outlined v-model="alimento.desCompleta" type="text" label="Descrição completa" :error="!validaDesCompleta" error-message="Descrição completa é obrigatória!" maxlength="50" autogrow="true"/>
        </div>
        <div class="col-sm-12 col-md-6 q-pa-sm">
          <q-input outlined v-model="alimento.desResumida" type="text" label="Descrição resumida" maxlength="25"/>
        </div>
        <div class="col-sm-12 col-md-3 q-pa-sm">
          <q-input outlined v-model="alimento.qtdAlimento" label="Quantidade de alimento (g)" type="numeric" :error="!validaQtdAlimento" error-message="Quantidade de alimento é obrigatória!" maxlength="4"></q-input>
        </div>
        <div class="col-sm-12 col-md-3 q-pa-sm">
          <q-input outlined v-model="alimento.qtdCarboidrato" label="Quantidade de carboidrato (g)" type="numeric" :error="!validaQtdCarboidrato" error-message="Quantidade de carboidrato é obrigatória!" maxlength="4"></q-input>
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
  name: 'Alimento',
  components: {},
  data: function () {
    return {
      alimento: {},
      validaQtdAlimento: true,
      validaQtdCarboidrato: true,
      validaDesCompleta: true
    }
  },
  methods: {
    salvar () {
      if(this.validar()){
        axios.post('http://localhost:8082/alimento/', this.setObjeto())
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
      this.validaQtdAlimento = true
      this.validaQtdCarboidrato = true
      this.validaDesCompleta = true

      if(this.alimento.qtdAlimento == null || this.alimento.qtdAlimento == undefined ||  this.alimento.qtdAlimento == ''){
        valida = false
        this.validaQtdAlimento = false
      }

      if(this.alimento.qtdCarboidrato == null || this.alimento.qtdCarboidrato == undefined ||  this.alimento.qtdCarboidrato == ''){
        valida = false
        this.validaQtdCarboidrato = false
      }

      if(this.alimento.desCompleta == null || this.alimento.desCompleta == undefined ||  this.alimento.desCompleta == ''){
        valida = false
        this.validaDesCompleta = false
      }

      return valida
    },
     //TODO - IMPLEMENTAR UMA FORMATAÇÃO DE DATA NO UTILS
    setObjeto(){
      const alimento = {
        desCompleta: this.alimento.desCompleta,
        desResumida: this.alimento.desResumida,
        qtdCarboidrato: this.alimento.qtdCarboidrato,
        qtdAlimento: this.alimento.qtdAlimento,
        qtdCarboidratoGrama: this.alimento.qtdCarboidratoGrama,
        datCadastro: new Date(),
        datAlteracao: null,
        usuario: "Caju" //TODO - FAZER LOGIN USUÁRIO, AUTENTICAÇÃO, AUTORIZAÇÃO, ETC
      }

      return alimento
    },
    carregamentoInicial(){
    }
  },
  mounted() {
    this.carregamentoInicial()
  }
}
</script>
