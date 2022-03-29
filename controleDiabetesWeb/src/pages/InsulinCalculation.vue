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
  name: 'InsulinCalculation',
  components: {},
  data: function () {
    return {
      insulinCalculation: {}
    }
  },
  methods: {
    save () {
      if(this.validate()){
        axios.post('http://localhost:8082/insulinCalculation/', this.setObject())
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

      return valid
    },
     //TODO - IMPLEMENTAR UMA FORMATAÇÃO DE DATA NO UTILS
    setObject(){
      const insulinCalculation = {
         // TODO - IMPLEMENTAR UM UNDEFINED TO NULL
        registerDate: this.insulinCalculation.datCadastro == undefined ? null : this.insulinCalculation.datCadastro,
        lastUpdateDate: this.insulinCalculation.datAlteracao == undefined ? null : this.insulinCalculation.datAlteracao,
        user: "Caju" //TODO - FAZER LOGIN USUÁRIO, AUTENTICAÇÃO, AUTORIZAÇÃO, ETC
      }

      return insulinCalculation
    },
    inicializationLoad(){
    }
  },
  mounted() {
    this.inicializationLoad()
  }
}
</script>
