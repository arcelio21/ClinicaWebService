package com.clinicawebservice.service.addressService.AddressEx;


import com.clinicawebservice.daoData.addressDAO.addressEx.TdistrictDAO;
import com.clinicawebservice.voData.addressDTO.exaddressDTO.TdistrictDto;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import java.util.List;

@Stateless(mappedName = "ejb/districtService")
@WebService(endpointInterface = "com.clinicawebservice.service.addressService.AddressEx.TdistrictService")
public class TdistrictServiceImpl implements TdistrictService {

    @Inject
    private TdistrictDAO tdistrictDAO;
    /**
     * METODO DE QUE LISTA TODAS LOS DISTRITOS DISPONIBLES
     *
     * @return List<TdistrictDto>
     */
    @Override
    public List<TdistrictDto> listDistricts() {
        return this.tdistrictDAO.listDistricts();
    }

    /**
     * METODO QUE REALIZA BUSQUEDA DE DISTRITOS POR SU ID
     *
     * @param tdistrictDto
     * @return TprovinceDto
     */
    @Override
    public TdistrictDto searchDistrictById(TdistrictDto tdistrictDto) {
        return this.tdistrictDAO.searchDistrictById(tdistrictDto);
    }

    /**
     * METODO QUE INSERTA NUEVA DISTRITO
     *
     * @param tdistrictDto
     * @return boolean
     */
    @Override
    public boolean insertDistrict(TdistrictDto tdistrictDto) {
        return this.tdistrictDAO.insertDistrict(tdistrictDto);
    }

    /**
     * METODO QUE ACTAULIZA INFORMACION DE UNA PROVINCIA EN ESPECIFICO
     *
     * @param tdistrictDto
     * @return boolean
     */
    @Override
    public boolean updateDistrict(TdistrictDto tdistrictDto) {
        return this.tdistrictDAO.updateDistrict(tdistrictDto);
    }

    /**
     * METODO QUE ELIMINA DATOS DE UNA PROVINCIA EN ESPECIFICO
     *
     * @param tdistrictDto
     * @return
     */
    @Override
    public boolean deleteDistrict(TdistrictDto tdistrictDto) {
        return this.tdistrictDAO.deleteDistrict(tdistrictDto);
    }
}
