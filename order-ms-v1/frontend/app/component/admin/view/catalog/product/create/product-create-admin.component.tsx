import {Button} from 'primereact/button';
import {Column} from 'primereact/column';
import {TabView, TabPanel} from 'primereact/tabview';
import {Dialog} from 'primereact/dialog';
import {InputNumber, InputNumberChangeEvent} from 'primereact/inputnumber';
import {InputText} from 'primereact/inputtext';
import {classNames} from 'primereact/utils';
import { InputTextarea } from 'primereact/inputtextarea';
import React, {useEffect, useState} from 'react';
import {Calendar, CalendarChangeEvent} from 'primereact/calendar';
import { format } from 'date-fns';
import {InputSwitch, InputSwitchChangeEvent} from 'primereact/inputswitch';
import {Dropdown, DropdownChangeEvent} from 'primereact/dropdown';
import {MultiSelect, MultiSelectChangeEvent} from 'primereact/multiselect';
import {MessageService} from 'app/zynerator/service/MessageService';

import {ProductAdminService} from 'app/controller/service/admin/ProductAdminService.service';
import  {ProductDto}  from 'app/controller/model/Product.model';
import {ProductCriteria} from "app/controller/criteria/ProductCriteria.model";

import {ProductCategoryDto} from 'app/controller/model/ProductCategory.model';
import {ProductCategoryAdminService} from 'app/controller/service/admin/ProductCategoryAdminService.service';
import {TFunction} from "i18next";
import {Toast} from "primereact/toast";
import useCreateHook from "app/component/zyhook/useCreate.hook";



type ProductCreateAdminType = {
    visible: boolean,
    onClose: () => void,
    add: (item: ProductDto) => void,
    showToast: React.Ref<Toast>,
    list: ProductDto[],
    service: ProductAdminService,
    t: TFunction
}
const Create: React.FC<ProductCreateAdminType> = ({visible, onClose, add, showToast, list, service, t}) => {


    const isFormValid = () => {
    let errorMessages = new Array<string>();
                if(item.libelle == '')
                errorMessages.push("libelle is required")
                if(item.code == '')
                errorMessages.push("code is required")
        return errorMessages.length == 0 ;
    }
    const emptyItem = new ProductDto();
        const {
            item,
            setItem,
            submitted,
            setSubmitted,
            activeIndex,
            setActiveIndex,
            activeTab,
            setActiveTab,
            onInputTextChange,
            onInputDateChange,
            onInputNumerChange,
            onMultiSelectChange,
            onBooleanInputChange,
            onTabChange,
            onDropdownChange,
            hideDialog,
            saveItem,
            formateDate
        } = useCreateHook<ProductDto, ProductCriteria>({list, emptyItem, onClose, add, showToast,service, isFormValid})
    const [productCategorys, setProductCategorys] = useState<ProductCategoryDto[]>([]);


    const productCategoryAdminService = new ProductCategoryAdminService();
    useEffect(() => {
        productCategoryAdminService.getList().then(({data}) => setProductCategorys(data)).catch(error => console.log(error));
    }, []);








    const itemDialogFooter = ( <>
        <Button label={t("cancel")} icon="pi pi-times" text onClick={hideDialog} />
        <Button label={t("save")} icon="pi pi-check" onClick={saveItem} /> </>
    );

return(
        <Dialog visible={visible} style={{width: '70vw'}} header={{'product.tabPan' | translate}} modal className="p-fluid" footer={itemDialogFooter} onHide={hideDialog} >
        <TabView activeIndex={activeIndex} onTabChange={onTabChange}>
            <TabPanel header={{'product.tabPan' | translate}}>
                <div className="formgrid grid">
                    <div className="field col-6">
                        <label htmlFor="libelle">{{'product.libelle' | translate}}</label>
                        <InputText id="libelle" value={item.libelle} onChange={(e) => onInputTextChange(e, 'libelle')} required className={classNames({'p-invalid': submitted && !item.libelle})} />
                        {submitted && !item.libelle && <small className="p-invalid">Libelle is required.</small>}
                    </div>
                    <div className="field col-6">
                        <label htmlFor="code">{{'product.code' | translate}}</label>
                        <InputText id="code" value={item.code} onChange={(e) => onInputTextChange(e, 'code')} required className={classNames({'p-invalid': submitted && !item.code})} />
                        {submitted && !item.code && <small className="p-invalid">Code is required.</small>}
                    </div>
                    <div className="field col-5">
                        <label htmlFor="productCategory">{{'product.productCategory' | translate}}</label>
                        <Dropdown  id="productCategoryDropdown"  value={item.productCategory} options={productCategorys} onChange={(e) => onDropdownChange(e, 'productCategory')}   placeholder={{'product.productCategoryPlaceHolder' | translate}} filter filterPlaceholder={{'product.productCategoryPlaceHolderFilter' | translate}} optionLabel="libelle" showClear/>
                    </div>
                </div>
            </TabPanel>
        </TabView>
    </Dialog>
);
};
export default Create;
