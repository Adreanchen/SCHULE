<?php

use app\models\Produkte;
use yii\helpers\Html;
use yii\helpers\Url;
use yii\grid\ActionColumn;
use yii\grid\GridView;
use yii\widgets\Pjax;
/** @var yii\web\View $this */
/** @var app\models\ProdukteSearch $searchModel */
/** @var yii\data\ActiveDataProvider $dataProvider */

$this->title = Yii::t('app', 'Produktes');
$this->params['breadcrumbs'][] = $this->title;
?>
<div class="produkte-index">

    <h1><?= Html::encode($this->title) ?></h1>

    <p>
        <?= Html::a(Yii::t('app', 'Create Produkte'), ['create'], ['class' => 'btn btn-success']) ?>
    </p>

    <?php Pjax::begin(); ?>
    <?php // echo $this->render('_search', ['model' => $searchModel]); ?>

    <?= GridView::widget([
        'dataProvider' => $dataProvider,
        'filterModel' => $searchModel,
        'columns' => [
            ['class' => 'yii\grid\SerialColumn'],

            'ProduktID',
            'Produktname',
            'Produktkategorie',
            'Stueckpreis',
            'LieferantenID',
            [
                'class' => ActionColumn::className(),
                'urlCreator' => function ($action, Produkte $model, $key, $index, $column) {
                    return Url::toRoute([$action, 'ProduktID' => $model->ProduktID]);
                 }
            ],
        ],
    ]); ?>

    <?php Pjax::end(); ?>

</div>
