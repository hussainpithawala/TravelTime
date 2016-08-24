import { EventEmitter } from 'events';

import dispatcher from '../dispatchers/Dispatcher.jsx';

class LocationsStore extends EventEmitter {
  constructor() {
    super();
    this.locations = '';
  }

  getAllLocations() {
    return this.locations;
  }

  handleAction(action) {
    console.log('Handling receive action..', action);
    switch (action.type)  {
      case "RECEIVE_LOCATIONS" :
      {
        this.locations = action.locations;
        this.emit("change");
        break;
      }
    }
  }
}

const locationsStore = new LocationsStore;

dispatcher.register(locationsStore.handleAction.bind(locationsStore));

export default locationsStore;