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

import  {OrderBoutiqueDto}  from 'app/controller/model/OrderBoutique.model';

type OrderBoutiqueViewAdminType = {
    visible: boolean,
    onClose: () => void,
    selectedItem: OrderBoutiqueDto,
    t: TFunction
}

const View: React.FC<OrderBoutiqueViewAdminType> = ({visible,onClose,selectedItem, t}) => {

    const {
    onTabChange,
    hideDialog,
    itemDialogFooter,
    formateDate,
    parse,
    parseToIsoFormat,
    adaptDate,
    activeIndex
    } = useViewHook<OrderBoutiqueDto>({selectedItem, onClose})

        return(
<Dialog visible={visible} style={{width: '70vw'}} header={{'orderBoutique.tabPan' | translate}} modal className="p-fluid" footer={itemDialogFooter} onHide={hideDialog} >
<TabView activeIndex={activeIndex} onTabChange={onTabChange}>
<TabPanel header={{'orderBoutique.tabPan' | translate}}>
    <div className="formgrid grid">

            <div className="field col-6">
                <label htmlFor="reference">{{'orderBoutique.reference' | translate}}</label>
                <InputText id="reference" value={selectedItem?.reference} disabled   />
            </div>

        <div className="field col-6">
            <label htmlFor="orderDate">{{'orderBoutique.orderDate' | translate}}</label>
            <Calendar id="orderDate" value={adaptDate(selectedItem?.orderDate)} disabled dateFormat="dd/mm/yy" showIcon={true}  />
        </div>

                <div className="field col-6">
                    <label htmlFor="total">{{'orderBoutique.total' | translate}}</label>
                    <InputNumber id="total" value={selectedItem.total} disabled/>
                </div>

                <div className="field col-6">
                    <label htmlFor="orderStatus">{{'orderBoutique.orderStatus' | translate}}</label>
                    <InputText  id="orderStatusDropdown"  value={selectedItem?.orderStatus?.libelle}  disabled  />
                </div>
        </div>
</TabPanel>
    <TabPanel header={{'orderBoutique.orderLines' | translate}}>
                <div className="card">
                    <DataTable value={selectedItem?.orderLines} tableStyle={{minWidth: '50rem'}} dataKey="id">
                                <Column field="price" header={{'orderLine.price' | translate}}   ></Column>
                                <Column field="quantity" header={{'orderLine.quantity' | translate}}   ></Column>
                                <Column field="quantityReceived" header={{'orderLine.quantityReceived' | translate}}   ></Column>
                                <Column field="product.libelle" header={{'orderLine.product' | translate}}></Column>
                    </DataTable>
                </div>
        </TabPanel>
</TabView>
</Dialog>
);
};
export default View;
