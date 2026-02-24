<?php

use app\models\Lieferanten;
use yii\helpers\Html;
use yii\helpers\Url;
use yii\grid\ActionColumn;
use yii\grid\GridView;
use yii\widgets\Pjax;
/** @var yii\web\View $this */
/** @var app\models\LieferantenSearch $searchModel */
/** @var yii\data\ActiveDataProvider $dataProvider */

$this->title = Yii::t('app', 'Lieferantens');
$this->params['breadcrumbs'][] = $this->title;
?>
<div class="lieferanten-index">

    <h1><?= Html::encode($this->title) ?></h1>

    <p>
        <?= Html::a(Yii::t('app', 'Create Lieferanten'), ['create'], ['class' => 'btn btn-success']) ?>
    </p>

    <?php Pjax::begin(); ?>
    <?php // echo $this->render('_search', ['model' => $searchModel]); ?>

    <?= GridView::widget([
        'dataProvider' => $dataProvider,
        'filterModel' => $searchModel,
        'columns' => [
            ['class' => 'yii\grid\SerialColumn'],

            'LieferantenID',
            'Lieferantenname',
            'Lieferanten_Email:email',
            [
                'class' => ActionColumn::className(),
                'urlCreator' => function ($action, Lieferanten $model, $key, $index, $column) {
                    return Url::toRoute([$action, 'LieferantenID' => $model->LieferantenID]);
                 }
            ],
        ],
    ]); ?>

    <?php Pjax::end(); ?>

</div>
