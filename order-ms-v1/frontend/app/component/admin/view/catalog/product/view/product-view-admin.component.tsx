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

import  {ProductDto}  from 'app/controller/model/Product.model';

type ProductViewAdminType = {
    visible: boolean,
    onClose: () => void,
    selectedItem: ProductDto,
    t: TFunction
}

const View: React.FC<ProductViewAdminType> = ({visible,onClose,selectedItem, t}) => {

    const {
    onTabChange,
    hideDialog,
    itemDialogFooter,
    formateDate,
    parse,
    parseToIsoFormat,
    adaptDate,
    activeIndex
    } = useViewHook<ProductDto>({selectedItem, onClose})

        return(
<Dialog visible={visible} style={{width: '70vw'}} header={{'product.tabPan' | translate}} modal className="p-fluid" footer={itemDialogFooter} onHide={hideDialog} >
<TabView activeIndex={activeIndex} onTabChange={onTabChange}>
<TabPanel header={{'product.tabPan' | translate}}>
    <div className="formgrid grid">

            <div className="field col-6">
                <label htmlFor="libelle">{{'product.libelle' | translate}}</label>
                <InputText id="libelle" value={selectedItem?.libelle} disabled   />
            </div>

            <div className="field col-6">
                <label htmlFor="code">{{'product.code' | translate}}</label>
                <InputText id="code" value={selectedItem?.code} disabled   />
            </div>

                <div className="field col-6">
                    <label htmlFor="productCategory">{{'product.productCategory' | translate}}</label>
                    <InputText  id="productCategoryDropdown"  value={selectedItem?.productCategory?.libelle}  disabled  />
                </div>
        </div>
</TabPanel>
</TabView>
</Dialog>
);
};
export default View;
