<template>
  <div class="q-pa-md">
    <q-table
      grid
      title="Alimentos"
      :data="data"
      :columns="columns"
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
  name: 'FoodSearch',
  components: {},
  data: function () {
    return {
      filter: '',
      columns: [
        { name: 'summaryDescription', align: 'center', label: 'Descrição', field: 'summaryDescription', sortable: true },
        { name: 'carbohydrateQty', align: 'center', label: 'Quantidade de carboidratos por grama', field: 'carbohydrateQty', sortable: true },
        { name: 'lastUpdateDate', align: 'center', label: 'Última atualização', field: 'lastUpdateDate', sortable: true }
      ],
      data: [
      ]
    }
  },
  methods: {},
  mounted() {}
}
</script>