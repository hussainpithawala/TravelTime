import { EventEmitter } from 'events';

import dispatcher from '../dispatchers/Dispatcher.jsx';

class HotelsStore extends EventEmitter {
  constructor() {
    super();
    this.hotels = '';
  }

  getAllHotels() {
    return this.hotels;
  }

  handleAction(action) {
    console.log('Handling receive action..', action);
    switch (action.type)  {
      case "RECEIVE_HOTELS" :
      {
        this.hotels = action.hotels;
        this.emit("change");
        break;
      }
    }
  }
}

const hotelsStore = new HotelsStore;

dispatcher.register(hotelsStore.handleAction.bind(hotelsStore));

export default hotelsStore;