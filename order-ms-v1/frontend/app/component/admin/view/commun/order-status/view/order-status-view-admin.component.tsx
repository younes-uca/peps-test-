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

import  {OrderStatusDto}  from 'app/controller/model/OrderStatus.model';

type OrderStatusViewAdminType = {
    visible: boolean,
    onClose: () => void,
    selectedItem: OrderStatusDto,
    t: TFunction
}

const View: React.FC<OrderStatusViewAdminType> = ({visible,onClose,selectedItem, t}) => {

    const {
    onTabChange,
    hideDialog,
    itemDialogFooter,
    formateDate,
    parse,
    parseToIsoFormat,
    adaptDate,
    activeIndex
    } = useViewHook<OrderStatusDto>({selectedItem, onClose})

        return(
<Dialog visible={visible} style={{width: '70vw'}} header={{'orderStatus.tabPan' | translate}} modal className="p-fluid" footer={itemDialogFooter} onHide={hideDialog} >
<TabView activeIndex={activeIndex} onTabChange={onTabChange}>
<TabPanel header={{'orderStatus.tabPan' | translate}}>
    <div className="formgrid grid">

            <div className="field col-6">
                <label htmlFor="libelle">{{'orderStatus.libelle' | translate}}</label>
                <InputText id="libelle" value={selectedItem?.libelle} disabled   />
            </div>

            <div className="field col-6">
                <label htmlFor="code">{{'orderStatus.code' | translate}}</label>
                <InputText id="code" value={selectedItem?.code} disabled   />
            </div>

            <div className="field col-6">
                <label htmlFor="style">{{'orderStatus.style' | translate}}</label>
                <InputText id="style" value={selectedItem?.style} disabled   />
            </div>

        </div>
</TabPanel>
</TabView>
</Dialog>
);
};
export default View;
