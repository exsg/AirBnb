/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldencompany.airbnb.mappers;

import com.goldencompany.airbnb.dto.input.ListingCreationDTO;
import com.goldencompany.airbnb.dto.input.ListingUpdateDTO;
import com.goldencompany.airbnb.dto.output.RuleDTO;
import com.goldencompany.airbnb.entity.Rule;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author george
 */
public class RuleMapper {

    public RuleDTO toDTO(Rule entity) {
        RuleDTO dto = new RuleDTO();

        dto.setId(entity.getId());
        dto.setRule(entity.getRule());

        return dto;
    }

    public List<Rule> toEntities(ListingUpdateDTO dto) {
        List<Rule> ruleList = new ArrayList();

        if (dto.isHasPet()) {
            Rule r = new Rule();
            r.setId(1);
            ruleList.add(r);
        }
        if (dto.isHasEvent()) {
            Rule r = new Rule();
            r.setId(2);
            ruleList.add(r);
        }

        if (dto.isHasSmoking()) {
            Rule r = new Rule();
            r.setId(3);
            ruleList.add(r);
        }

        return ruleList;

    }

    public List<Rule> toEntities(ListingCreationDTO input) {
//        return new ArrayList();
        List<Rule> ruleList = new ArrayList();

        if (input.isHasPet()) {
            Rule r = new Rule();
            r.setId(1);
            ruleList.add(r);
        }
        if (input.isHasEvent()) {
            Rule r = new Rule();
            r.setId(2);
            ruleList.add(r);
        }

        if (input.isHasSmoking()) {
            Rule r = new Rule();
            r.setId(3);
            ruleList.add(r);
        }

        return ruleList;

    }

}
