import axios from 'axios';

const url ="http://localhost:8080"

class Service{

    getCountries(){
        return axios.get(url + '/countries');
    }

    getCustomers(){
        return axios.get(url + '/customers');
    }

    getCustomersByCountry(countryPrefix){
        return axios.get(url + '/customers/country', { params : { countryPrefix }});
    }

    getCustomersWithValidity(validity){
        return axios.get(url + '/customers/validity' , { params : { validity } });
    }

    getCustomersByCountryAndValidity(countryPrefix, validity){
        return axios.get(url + '/customers/country-validity' , { params : { countryPrefix, validity } });
    }

    getCustomersPaginated(offset, pageSize){
        return axios.get(url + '/customers/paginated/' + offset + '/' + pageSize);
    }

}

export default new Service()