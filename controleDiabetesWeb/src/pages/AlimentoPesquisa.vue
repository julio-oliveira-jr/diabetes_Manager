<template>
  <div class="q-pa-md">
    <q-table
      grid
      title="Alimentos"
      :data="conteudo"
      :columns="colunas"
      row-key="name"
      :filter="filter"
      hide-header
    >
      <template v-slot:top-right>
        <q-input borderless dense debounce="300" v-model="filter" placeholder="Search">
          <template v-slot:append>
            <q-icon name="search" />
          </template>
        </q-input>
      </template>
    </q-table>
  </div>
</template>

<script>

export default {
  name: 'AlimentoPesquisa',
  components: {},
  data: function () {
    return {
      filter: '',
      colunas: [
        { name: 'desResumida', align: 'center', label: 'Descrição', field: 'desResumida', sortable: true },
        { name: 'qtdCarboidratoGrama', align: 'center', label: 'Quantidade de carboidratos por grama', field: 'qtdCarboidratoGrama', sortable: true },
        { name: 'dtAtualizacao', align: 'center', label: 'Última atualização', field: 'dtAtualizacao', sortable: true }
      ],
      conteudo: [
      ]
    }
  },
  methods: {},
  mounted() {}
}
</script>