import { createRouter as createRouter, createWebHistory } from 'vue-router'
import { useStore } from 'vuex'

// Import components
import HomeView from '../views/HomeView.vue';
import LoginView from '../views/LoginView.vue';
import LogoutView from '../views/LogoutView.vue';
import RegisterView from '../views/RegisterView.vue';
import VoteView from '../views/VoteView.vue';
import ProfileView from '../views/ProfileView.vue';
import SocialView from '../views/SocialView.vue';
//import CommentHomeView from '../views/CommentHomeView.vue';
import CommentTopicDetailsView from '../views/CommentTopicDetailsView.vue';
import CommentAddMessageView from '../views/CommentAddMessageView.vue';
import CommentAddTopicView from '../views/CommentAddTopicView.vue';
import CommentEditTopicView from '../views/CommentEditTopicView.vue';
import CommentNotFoundView from '../views/CommentNotFoundView.vue';
import CommentEditMessageView from '../views/CommentEditMessageView.vue';
import CommentMessageDetailsView from '../views/CommentMessageDetailsView.vue';

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: "/login",
    name: "login",
    component: LoginView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/logout",
    name: "logout",
    component: LogoutView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/register",
    name: "register",
    component: RegisterView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: '/vote',
    name: 'Vote',
    component: VoteView,
  },
  {
    path: '/profile',
    name: 'profile',
    component: ProfileView,
  },
  {
    path: '/social',
    name: 'social',
    component: SocialView,
  },
  {
    path: "/social/not-found",
    name: "CommentNotFoundView",
    component: CommentNotFoundView
  },
  // {
  //   path: '/social',
  //   name: 'CommentHomeView',
  //   component: CommentHomeView
  // },
  {
    path: '/social/topic/:topicId',
    name: 'CommentTopicDetailsView',
    component: CommentTopicDetailsView
  },
  {
    path: '/social/topic/create',
    name: 'CommentAddTopicView',
    component: CommentAddTopicView
  },
  {
    path: '/social/topic/:topicId/edit',
    name: 'CommentEditTopicView',
    component: CommentEditTopicView
  },
  {
    path: '/social/topic/:topicId/message/:messageId',
    name: 'CommentMessageDetailsView',
    component: CommentMessageDetailsView
  },
  {
    path: '/social/topic/:topicId/message/create',
    name: 'CommentAddMessageView',
    component: CommentAddMessageView
  },
  {
    path: '/social/topic/:topicId/message/:messageId/edit',
    name: 'CommentEditMessageView',
    component: CommentEditMessageView
  },

]; 

// Create the router
const router = createRouter({
  history: createWebHistory(),
  routes: routes
});

router.beforeEach((to) => {

  // Get the Vuex store
  const store = useStore();

  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    return {name: "login"};
  }
  // Otherwise, do nothing and they'll go to their next destination
});

export default router;
