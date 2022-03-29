<template>
    <q-dialog v-model="aviso">
      <q-card>
        <q-card-section>
          <div class="text-h6">Alert</div>
        </q-card-section>

        <q-card-section class="q-pt-none">
         {{mensagem}}
        </q-card-section>

        <q-card-actions align="right">
          <q-btn flat label="OK" color="primary" v-close-popup />
        </q-card-actions>
      </q-card>
    </q-dialog>
</template>

<script>

export default {
  name: 'JDialog',
  components: {},
  props: {
      mensagem: {
          type: String,
          default: ''
      },
      mostraAviso: {
          type: Boolean,
          default: false
      }
  },
  data: function () {
    return {
        aviso: mostraAviso
    }
  },
  methods: {},
  mounted: {}
}
</script>