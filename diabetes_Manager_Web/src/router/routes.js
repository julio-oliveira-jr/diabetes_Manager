
const routes = [
  {
    path: '/',
    component: () => import('layouts/MainLayout.vue'),
    children: [
      { path: '', component: () => import('pages/IndexPage.vue') },    
      { path: '/bloodGlucose', component: () => import('src/pages/Glucose.vue') },
      { path: '/bloodGlucoseSearch', component: () => import('pages/GlucoseSearch.vue') },
      { path: '/food', component: () => import('src/pages/Food.vue') },
      { path: '/foodSearch', component: () => import('pages/FoodSearch.vue') },
      { path: '/insulinCalculationType', component: () => import('pages/InsulinCalculationType.vue') },
      { path: '/insulinCalculation', component: () => import('pages/InsulinCalculation.vue') }
    ]
  },

  // Always leave this as last one,
  // but you can also remove it
  {
    path: '/:catchAll(.*)*',
    component: () => import('pages/ErrorNotFound.vue')
  }
]

export default routes
