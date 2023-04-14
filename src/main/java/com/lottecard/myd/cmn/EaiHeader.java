package com.lottecard.myd.cmn;

import org.beanio.annotation.Record;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Record(name="EaiHeader" , maxOccurs=1)
public class EaiHeader extends CommonHeader {
}
