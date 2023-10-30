import {Column} from 'primereact/column';
import {TabPanel, TabView} from 'primereact/tabview';
import {DataTable} from 'primereact/datatable';
import {Dialog} from 'primereact/dialog';
import {InputNumber} from 'primereact/inputnumber';
import {InputText} from 'primereact/inputtext';
import {InputTextarea} from 'primereact/inputtextarea';
import React from 'react';
import {Calendar} from 'primereact/calendar';
import {InputSwitch} from 'primereact/inputswitch';
import {TFunction} from "i18next";
import useViewHook from "app/component/zyhook/useViewhook";

import  {ProductCategoryDto}  from 'app/controller/model/ProductCategory.model';

type ProductCategoryViewAdminType = {
    visible: boolean,
    onClose: () => void,
    selectedItem: ProductCategoryDto,
    t: TFunction
}

const View: React.FC<ProductCategoryViewAdminType> = ({visible,onClose,selectedItem, t}) => {

    const {
    onTabChange,
    hideDialog,
    itemDialogFooter,
    formateDate,
    parse,
    parseToIsoFormat,
    adaptDate,
    activeIndex
    } = useViewHook<ProductCategoryDto>({selectedItem, onClose})

        return(
<Dialog visible={visible} style={{width: '70vw'}} header={{'productCategory.tabPan' | translate}} modal className="p-fluid" footer={itemDialogFooter} onHide={hideDialog} >
<TabView activeIndex={activeIndex} onTabChange={onTabChange}>
<TabPanel header={{'productCategory.tabPan' | translate}}>
    <div className="formgrid grid">

            <div className="field col-6">
                <label htmlFor="libelle">{{'productCategory.libelle' | translate}}</label>
                <InputText id="libelle" value={selectedItem?.libelle} disabled   />
            </div>

            <div className="field col-6">
                <label htmlFor="code">{{'productCategory.code' | translate}}</label>
                <InputText id="code" value={selectedItem?.code} disabled   />
            </div>

        </div>
</TabPanel>
</TabView>
</Dialog>
);
};
export default View;
