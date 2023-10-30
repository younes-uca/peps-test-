import {NextPageWithLayout} from 'next';
import {ReactNode} from 'react';

import ProductCategorysList from 'app/component/admin/view/catalog/product-category/list/product-category-list-admin.component';
import Layout from 'layout/layout';
import AuthGuard from 'app/component/auth/auth-guard.component';

const ProductCategorys: NextPageWithLayout = () => {
    return <ProductCategorysList />
}

ProductCategorys.getLayout = function getLayout(page: ReactNode) {
    return (
    <AuthGuard>
        <Layout>
            {page}
        </Layout>
    </AuthGuard>
    )
}

export default ProductCategorys;
