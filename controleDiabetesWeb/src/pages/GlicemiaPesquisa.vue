<template>
  <div class="q-pa-md">
    <div class="row">
      <div class="col-sm-12 col-md-8">
        <q-date v-model="fitro" range />
      </div>
    </div>
   <div class="q-pt-md">
    <q-card class>
      <q-table
        :data="conteudo"
        :columns="colunas"
        row-key="name">
        </q-table>
    </q-card>
    </div>
  </div>
</template>

<script>

import axios from 'axios';

export default {
  name: 'GlicemiaPesquisa',
  components: {},
  data: function () {
    return {
      filtro: "",
      colunas: [
        { name: 'datGlicemia', align: 'left', label: 'Data', field: 'datGlicemia', sortable: true },
        { name: 'hrGlicemia', align: 'left', label: 'Horário', field: 'hrGlicemia', sortable: true },
        {
          name: 'vlrGlicemia',
          required: true,
          label: 'Valor da glicemia',
          align: 'left',
          field: 'vlrGlicemia',
          format: val => `${val}`,
          sortable: true,
          classes: 'bg-grey-2 ellipsis',
          style: 'max-width: 100px',
          headerClasses: 'bg-primary text-white'
        },
        { name: 'datCadastro', align: 'left', label: 'Data de cadastro', field: 'datCadastro', sortable: true },
        { name: 'datAtualizacao', align: 'left', label: 'Data de atualização', field: 'datAtualizacao', sortable: true },
        { name: 'usuario', align: 'left', label: 'Usuário', field: 'usuario', sortable: true},
      ],
      conteudo: [
        {
          datGlicemia: '13/04/2021',
          hrGlicemia: '11:25',
          datCadastro: '13/04/2021 11:25',
          vlrGlicemia: 159,
          datAtualizacao: '13/04/2021 11:25',
          usuario: 'Julio'
        },
        {
          datGlicemia: '13/04/2021',
          hrGlicemia: '11:25',
          datCadastro: '13/04/2021',
          vlrGlicemia: 237,
          datAtualizacao: '13/04/2021 11:25',
          usuario: 'Camilla'
        },
        {
          datGlicemia: '13/04/2021',
          hrGlicemia: '11:25',
          datCadastro: '13/04/2021 11:25',
          vlrGlicemia: 262,
          datAtualizacao: '13/04/2021 11:25',
          usuario: 'Camilla'
        }
      ]
    }
  },
  methods: {},
  mounted() {}
}
</script>