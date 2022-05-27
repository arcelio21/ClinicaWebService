package com.clinicawebservice.service.addressService.AddressEx;



import com.clinicawebservice.daoData.addressDAO.addressEx.TprovinceDAO;
import com.clinicawebservice.voData.addressDTO.exaddressDTO.TprovinceDto;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import java.util.List;
@Stateless(mappedName = "ejb/provinceService")
@WebService(endpointInterface = "com.clinicawebservice.service.addressService.AddressEx.TprovinceService")
public class TprovinceServiceImpl implements TprovinceService{

    @Inject
    private TprovinceDAO tprovinceDAO;
    /**
     * METODO DE QUE LISTA TODAS LAS PROVINCIAS DISPONIBLES
     *
     * @return List<TprovinceDto>
     */
    @Override
    public List<TprovinceDto> listProvinces() {
        return this.tprovinceDAO.listProvinces();
    }

    /**
     * METODO QUE REALIZA BUSQUEDA DE PROVINCIA POR SU ID
     *
     * @param tprovinceDto
     * @return TprovinceDto
     */
    @Override
    public TprovinceDto searchProvinceById(TprovinceDto tprovinceDto) {
        return this.tprovinceDAO.searchProvinceById(tprovinceDto);
    }

    /**
     * METODO QUE INSERTA NUEVA PROVINCIA
     *
     * @param tprovinceDto
     * @return boolean
     */
    @Override
    public boolean insertProvince(TprovinceDto tprovinceDto) {
        return this.tprovinceDAO.insertProvince(tprovinceDto);
    }

    /**
     * METODO QUE ACTAULIZA INFORMACION DE UNA PROVINCIA EN ESPECIFICO
     *
     * @param tprovinceDto
     * @return boolean
     */
    @Override
    public boolean updateProvince(TprovinceDto tprovinceDto) {
        return this.tprovinceDAO.updateProvince(tprovinceDto);
    }

    /**
     * METODO QUE ELIMINA DATOS DE UNA PROVINCIA EN ESPECIFICO
     *
     * @param tprovinceDto
     * @return
     */
    @Override
    public boolean deleteProvince(TprovinceDto tprovinceDto) {
        return this.tprovinceDAO.deleteProvince(tprovinceDto);
    }
}
