import axios from 'axios';

class GoogleMaps {
  constructor() {
    this.googleMapAppended = false;
  }

  load() {
    var me  = this;
		if (!this.googleMapAppended) {
      axios({
        method: 'get',
        url: '/properties.json',
        responseType : 'json'
      })
      .then(function (response) {
        me.appendScript(response.data.GOOGLE_MAP_KEY).bind(me);
      })
      .catch(function (error) {
        console.log(error);
      });
    }
	}

  getSrc(key) {
    let src = 'https://maps.googleapis.com/maps/api/js?key=';
    src += key;
    return src;
  }
 
  appendScript(key) {
    const src = this.getSrc(key);
    const script = document.createElement('script');
    script.setAttribute('src', src);
    document.head.appendChild(script);
    this.googleMapAppended = true;
  }

}

const googleMaps = new GoogleMaps;

export default googleMaps;
