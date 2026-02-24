<?php

use app\models\Kunden;
use yii\helpers\Html;
use yii\helpers\Url;
use yii\grid\ActionColumn;
use yii\grid\GridView;
use yii\widgets\Pjax;
/** @var yii\web\View $this */
/** @var app\models\KundenSearch $searchModel */
/** @var yii\data\ActiveDataProvider $dataProvider */

$this->title = Yii::t('app', 'Kundens');
$this->params['breadcrumbs'][] = $this->title;
?>
<div class="kunden-index">

    <h1><?= Html::encode($this->title) ?></h1>

    <p>
        <?= Html::a(Yii::t('app', 'Create Kunden'), ['create'], ['class' => 'btn btn-success']) ?>
    </p>

    <?php Pjax::begin(); ?>
    <?php // echo $this->render('_search', ['model' => $searchModel]); ?>

    <?= GridView::widget([
        'dataProvider' => $dataProvider,
        'filterModel' => $searchModel,
        'columns' => [
            ['class' => 'yii\grid\SerialColumn'],

            'KundenID',
            'Kundenname',
            'Kunden_Email:email',
            [
                'class' => ActionColumn::className(),
                'urlCreator' => function ($action, Kunden $model, $key, $index, $column) {
                    return Url::toRoute([$action, 'KundenID' => $model->KundenID]);
                 }
            ],
        ],
    ]); ?>

    <?php Pjax::end(); ?>

</div>
