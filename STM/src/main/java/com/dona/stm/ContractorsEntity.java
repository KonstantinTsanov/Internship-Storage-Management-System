/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dona.stm;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Iliya Velev <velev_bg@mail.bg>
 */
public class ContractorsEntity implements IContractorsEntity{
    @Getter 
    @Setter(AccessLevel.PRIVATE)               
    private String bulstat;
    @Getter 
    @Setter(AccessLevel.PRIVATE) 
    private String name;
    @Getter 
    @Setter(AccessLevel.PRIVATE)
    private String address;
    @Getter 
    @Setter(AccessLevel.PRIVATE)
    private String accountablePerson;
    @Getter 
    @Setter(AccessLevel.PRIVATE)
    private String receiverOfGoods;
    @Getter 
    @Setter(AccessLevel.PRIVATE)
    private String fax;
    @Getter 
    @Setter(AccessLevel.PRIVATE)
    private String bank;
    @Getter 
    @Setter(AccessLevel.PRIVATE)
    private String bankCode;
    @Getter 
    @Setter(AccessLevel.PRIVATE)
    private String IBAN;
    @Getter 
    @Setter(AccessLevel.PRIVATE)
    private String taxRegistryNumber;
    @Getter 
    @Setter(AccessLevel.PRIVATE)
    private String VATregistration;
    @Getter 
    @Setter(AccessLevel.PRIVATE)
    private String phone;

    public ContractorsEntity(String bulstat,String name,String address,String accountablePerson,String receiverOfGoods,String fax,String bank,String bankCode,String IBAN,String taxRegistryNumber,String VATregistration,String phone) {
        setBulstat(bulstat);
        setName(name);
        setAddress(address);
        setAccountablePerson(accountablePerson);
        setReceiverOfGoods(receiverOfGoods);
        setFax(fax);
        setBank(bank);
        setBankCode(bankCode);
        setIBAN(IBAN);
        setTaxRegistryNumber(taxRegistryNumber);
        setVATregistration(VATregistration);
        setPhone(phone);
    }
}
