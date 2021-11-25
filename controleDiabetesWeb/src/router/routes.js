const routes = [
  {
    path: '/',
    component: () => import('layouts/MainLayout.vue'),
    children: [
      { path: '/glicemia', component: () => import('src/pages/Glicemia.vue') },
      { path: '/glicemiaPesquisa', component: () => import('pages/GlicemiaPesquisa.vue') },
      { path: '/alimento', component: () => import('src/pages/Alimento.vue') },
      { path: '/alimentoPesquisa', component: () => import('pages/AlimentoPesquisa.vue') }
    ]
  },

  // Always leave this as last one,
  // but you can also remove it
  {
    path: '*',
    component: () => import('pages/Error404.vue')
  }
]

export default routes
