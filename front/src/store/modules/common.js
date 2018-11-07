import axios from 'axios';

const common = {
  state: {
    postList: [],
  },

  getters: {
    // Vue의 computed
    //    : Vue의 computed와 같이 미리 연산된 값을 접근
  },

  mutations: {
    setPostList: (state, data) => { state.postList = data; },
  },

  actions: {
    // Vue의 method와 같지만 actions는 async method
    //    : actions에는 비동기 로직을 구현. (동기로직이 필요할 경우 commit으로 mutations에 구현한 함수를 호출)
    getPostList({ commit }) {
      const params = {};
      const url = '/getPostList';

      return axios.get(url, { params }).then((response) => {
        commit('setPostList', response.data);
      });
    },
  },
};

export default common;
