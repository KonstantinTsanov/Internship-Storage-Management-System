/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dona.stm;

/**
 *
 * @author Iliya Velev <velev_bg@mail.bg>
 */
public class FactoryContractors {
    
    public IContractorsEntity CreateContractor(String bulstat,String name,String address,String accountablePerson,String receiverOfGoods,String fax,String bank,String bankCode,String IBAN,String taxRegistryNumber,String VATregistration,String phone) {
        return new ContractorsEntity(bulstat,name,address,accountablePerson,receiverOfGoods,fax,bank,bankCode,IBAN,taxRegistryNumber,VATregistration,phone);
    }
}
