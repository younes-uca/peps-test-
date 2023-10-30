import {NextPageWithLayout} from 'next';
import {ReactNode} from 'react';

import OrderBoutiquesList from 'app/component/admin/view/order/order-boutique/list/order-boutique-list-admin.component';
import Layout from 'layout/layout';
import AuthGuard from 'app/component/auth/auth-guard.component';

const OrderBoutiques: NextPageWithLayout = () => {
    return <OrderBoutiquesList />
}

OrderBoutiques.getLayout = function getLayout(page: ReactNode) {
    return (
    <AuthGuard>
        <Layout>
            {page}
        </Layout>
    </AuthGuard>
    )
}

export default OrderBoutiques;
